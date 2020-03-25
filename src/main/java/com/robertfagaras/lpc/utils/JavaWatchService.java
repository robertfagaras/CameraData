package com.robertfagaras.lpc.utils;

import com.robertfagaras.lpc.model.LP;
import com.robertfagaras.lpc.repositories.LpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.*;

@Component
public class JavaWatchService {

    @Autowired
    LpRepo lpRepo;

    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;

    public JavaWatchService(Path dir) throws IOException{
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey, Path>();

        walkAndRegisterDirectories(dir);
    }

    private void registerDirectory(Path dir) throws IOException{
        WatchKey key = dir.register(watcher, ENTRY_CREATE);
        keys.put(key,dir);
    }

    private void walkAndRegisterDirectories(final Path start) throws IOException{
        Files.walkFileTree(start, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
                registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void processEvents(){
        for(;;){
            WatchKey key;
            try{
                key = watcher.take();
            } catch (InterruptedException e) {
                return;
            }

            Path dir = keys.get(key);
            if(dir == null){
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()){
                @SuppressWarnings("rawtypes")
                WatchEvent.Kind kind = event.kind();
                @SuppressWarnings("unchecked")
                Path name = ((WatchEvent<Path>) event).context();
                Path child = dir.resolve(name);

                System.out.format("%s: %s\n",event.kind().name(), child);
                addLPinDB(child);


                if (kind == ENTRY_CREATE) {
                    try{
                        if(Files.isDirectory(child)){
                            walkAndRegisterDirectories(child);
                        }
                    } catch (IOException e){

                    }
                }
            }

            boolean valid = key.reset();
            if(!valid) {
                keys.remove(key);

                if(keys.isEmpty()){
                    break;
                }
            }
        }
    }

    private void addLPinDB(Path child) {
        String photo = child.getFileName().toString();
        if(photo.endsWith(".jpg") || photo.endsWith(".jpeg") || photo.endsWith(".png")){
            String date = photo.substring(0,8);
            String time = photo.substring(8,12);
            String datetime = photo.substring(8,10) + ":" + photo.substring(10,12) + " - " + date;
            String number = photo.substring(photo.indexOf("_")+1,photo.indexOf("."));
            LP lp = new LP();
            lp.setDate(datetime);
            lp.setNumber(number);
            lpRepo.addLP(lp);

            List<LP> list = lpRepo.getLPs();
            list.forEach(System.out::println);
        }
    }
}

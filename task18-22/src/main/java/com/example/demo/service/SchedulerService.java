package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
@Service
@ManagedResource(objectName = "com.example.demo.service:type=SchedulerService")
public class SchedulerService {
    private final GameRepository gameRepository;
    private final AuthorRepository authorRepository;

    @ManagedOperation
    @Scheduled(cron = "0 */30 * * * *")
    public void doScheduledTask() throws IOException {
        List<Game> games = gameRepository.findAll();
        List<GameAuthor> gamedevs = authorRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        File entities = new File("src/main/resources/entities");
        File[] files = entities.listFiles();
        for(File f: files) {
            if(f.isFile()) {
                f.delete();
            }
        }
        for (Game i: games){
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/game#"+i.getName()+".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
        for (GameAuthor i: gamedevs){
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/game#"+i.getNickname()+".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
    }

    @Scheduled(cron = "30 * * * * *")
    public void checkJMX() throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, MBeanException, IOException {
        MBeanServerConnection connection = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.example.demo.service:type=SchedulerService");

        connection.invoke(objectName, "doScheduledTask", null, null);
    }
}


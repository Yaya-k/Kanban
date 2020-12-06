package com.telecom.kanban.utils;

import com.telecom.kanban.dao.DeveloperRepository;
import com.telecom.kanban.dao.TaskRepository;
import com.telecom.kanban.dao.TaskStatusRepository;
import com.telecom.kanban.dao.TaskTypeRepository;
import com.telecom.kanban.domain.Developer;
import com.telecom.kanban.domain.Task;
import com.telecom.kanban.domain.TaskStatus;
import com.telecom.kanban.domain.TaskType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    @Profile("test")
    CommandLineRunner initTaskStatus(TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository, DeveloperRepository developerRepository, TaskRepository taskRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                TaskStatus todo = new TaskStatus(1L, "TODO");

                taskStatusRepository.save(todo);

                TaskStatus doing = new TaskStatus(2L, "DOING");

                taskStatusRepository.save(doing);

                TaskStatus test = new TaskStatus(3L, "TEST");

                taskStatusRepository.save(test);


                TaskStatus done = new TaskStatus(4L, "DONE");

                taskStatusRepository.save(done);
                //--------------------------------------------
                TaskType bug=new TaskType(1L, "BUG");
                TaskType feature=new TaskType(2L, "FEATURE");
                taskTypeRepository.save(bug);
                taskTypeRepository.save(feature);
                //-------------------------------------------------

                Task task1=new Task();
                Task task2=new Task();
                task1.setTitle("feature login");
                Developer developer1=new Developer();
                task1.addDeveloper(developer1);
                task2.addDeveloper(developer1);

                taskRepository.save(task1);
                taskRepository.save(task2);
                developerRepository.save(developer1);
                //--------------------------------------------------


            }
        };
    }
}
package se.bth.managment.Models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Document(collection = "task")
    public class Task {
        @Id
        private String id;
        private Integer priority;
        private String name;
        private Integer StoryPoints;
        List<SubTask> subTasks;

        @Override
        public String toString() {
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = "";
            try {
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                jsonString = mapper.writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return jsonString;
        }
}

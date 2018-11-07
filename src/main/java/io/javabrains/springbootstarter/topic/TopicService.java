package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic(1, "Java 8", "Discussion abt Java 8"),
            new Topic(2, "Java 9", "Discussion abt Java 9"),
            new Topic(3, "Java 10", "Discussion abt Java 10")));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
         topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(int id) {

        return topicRepository.findOne(id);
       /* return topics.stream()
                .filter(topic -> topic.getId() == id)
                .findFirst().get();*/
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topicUpd, int id) {
/*        Topic topicToUpdate = topics.stream()
                .filter(topic -> topic.getId() == id)
                .findFirst().get();
        topicToUpdate.setName(topicUpd.getName());
        topicToUpdate.setDescription(topicUpd.getDescription());*/
        topicRepository.save(topicUpd);
    }

    public void deleteTopic(int id) {
        //topics.removeIf(topic -> topic.getId() == id);
        topicRepository.delete(id);
    }
}

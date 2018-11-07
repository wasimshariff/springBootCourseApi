package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {

        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById( @PathVariable("id") String id) {
        return topicService.getTopicById(Integer.parseInt(id));
    }

    @RequestMapping(path = "/topics", method = RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public void addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.PUT, consumes = "application/json",
            produces = "application/json")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

        topicService.updateTopic(topic, Integer.parseInt(id));
    }

    @RequestMapping(path = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {

        topicService.deleteTopic(Integer.parseInt(id));
    }

}

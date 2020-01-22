package working.org.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//This marks this class a business service
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	/*
	private List<Course> topics= new ArrayList<> (Arrays.asList(
			new Course("spring", "Spring Framework", "Spring Framework Description"),
			new Course("basit", "learning spring boot", "this is really exciting"),
			new Course("javascript", "react native", "will gonna learn this also iA")
					));
	*/
	public List<Course> getAllTopics(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
				
		
		
	}

	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
		/*
		for(int i=0; i<topics.size(); i++) {
			
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i,  topic);
				return ;
			}	
		}
		*/
		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
	
}

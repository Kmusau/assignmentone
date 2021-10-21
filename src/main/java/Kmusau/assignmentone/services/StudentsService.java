package Kmusau.assignmentone.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import Kmusau.assignmentone.model.Students;

@Service
public class StudentsService {

	private List<Students>students = new ArrayList<> (Arrays.asList(
            new Students("Jesse", "Kiragu", "2002100", "Data Science"),
            new Students("Brandon", "Williams", "2002102", "Software Engineering"),
            new Students("Joe", "Henderson", "2002103", "Artificial Intelligence")
    ));
	
	
	public List<Students> studentlist() {
		return students;
	}
	
	
	public Students singlestudent(String idnum){
		for(Students stude: students){
			if(stude.getIdnum().equals(idnum)){
				return stude;
			}
		}
		return null;
	}
	
	
	public void addstudent(Students stu) {
		students.add(stu);	
	}


	public void updatestudent(String idnum, Students stu) {
		for(int i =0; i<students.size(); i++){
			Students stude = students.get(i);
			if(stude.getIdnum().equals(idnum)){
				students.set(i, stu);
					return;
			}
		}
	}
	
}

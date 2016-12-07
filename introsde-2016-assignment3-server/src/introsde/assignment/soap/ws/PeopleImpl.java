package introsde.assignment.soap.ws;
import introsde.assignment.soap.model.HealthMeasureHistory;
import introsde.assignment.soap.model.Person;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.ws.People",
serviceName="PeopleService")
public class PeopleImpl implements People {

	//Method #1
	@Override
	public List<Person> getPeople() {
		return Person.getAll();
	}

	//Method #2
	@Override
	public Person readPerson(int id) {
		System.out.println("---> Reading Person by id = "+id);
		Person p = Person.getPersonById(id);

		if (p != null) {
			System.out.println("---> Found Person by id = "+id+" => "+p.getName());
		} else {
			System.out.println("---> Didn't find any Person with  id = "+id);
		}
		return p;
	}

	//Method #3
	@Override
	public int updatePerson(Person person) {
		Person existing = Person.getPersonById(person.getIdPerson());

		if (existing != null) {
			Person.updatePerson(person);
			return 0;
		}else{
			return -1;
		}
	}

	//Method #4
	@Override
	public int addPerson(Person person,  List<HealthMeasureHistory> m){
		if(m == null){
			Person p = Person.savePerson(person);
			return p.getIdPerson();
		}else{
			Person p = Person.savePerson(person);
			ArrayList<String> control = new ArrayList<>();
			for(int i=0; i<m.size(); i++){
				if(!control.contains(m.get(i).getMeasureType())){
					control.add(m.get(i).getMeasureType());
					m.get(i).setPerson(p);
					HealthMeasureHistory.saveHealthMeasureHistory(m.get(i));
				}
			}
			Person.getPersonById(p.getIdPerson());
			return p.getIdPerson();
		}	
	}

	//Method #5
	@Override
	public int deletePerson(int id) {
		Person p = Person.getPersonById(id);
		if (p!=null) {
			Person.removePerson(p);
			return 0;
		} else {
			return -1;
		}
	}

	//Method #6
	@Override
	public List<HealthMeasureHistory> readPersonHistory(int id, String measureType){
		System.out.println("---> Reading Person by id = "+id);
		Person p = Person.getPersonById(id);
		List<HealthMeasureHistory> history = null;
		if (p!=null) {
			System.out.println("---> Found Person by id = "+id+" => "+p.getName());
			history = Person.getHistory(p,measureType);
		} else {
			System.out.println("---> Didn't find any Person with  id = "+id);
		}
		return history;
	}
	//Method #7
	@Override
	public List<String> readMeasureTypes(){
		return HealthMeasureHistory.getMeasureTypes();
	}

	//Method #8
	@Override
	public HealthMeasureHistory readPersonMeasure(int id, String measureType, int mid){
		return HealthMeasureHistory.getHealthMeasureHistoryById(mid);
	}

	//Method #9
	@Override
	public int savePersonMeasure(int id, HealthMeasureHistory m){
		Person p = Person.getPersonById(id);
		if (p != null){
			m.setPerson(p);
			m = HealthMeasureHistory.saveHealthMeasureHistory(m);
			return m.getIdMeasureHistory();
		}else{    			
			return -1;
		}
	}

	//Method #10
	@Override
	public HealthMeasureHistory updatePersonMeasure(int id, HealthMeasureHistory m){
		HealthMeasureHistory h = HealthMeasureHistory.getHealthMeasureHistoryById(m.getIdMeasureHistory());
		if(h.getPerson().getIdPerson() == id){
			m.setPerson(h.getPerson());
			return HealthMeasureHistory.updateHealthMeasureHistory(m); 
		} else {
			return null;
		}
	}
}
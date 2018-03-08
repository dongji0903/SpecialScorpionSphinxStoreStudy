package practice.dao;

import org.springframework.stereotype.Repository;

@Repository("practiceDaoImpl")
public class PracticeDaoImpl implements PracticeDao {

	@Override
	public String sayHello(String s) {
		// TODO Auto-generated method stub
		return "HwaYeon Say : '" + s +"'";
	}

}

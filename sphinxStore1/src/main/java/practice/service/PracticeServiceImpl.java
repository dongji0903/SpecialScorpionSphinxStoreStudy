package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.dao.PracticeDao;

@Service("practiceServiceImpl")
public class PracticeServiceImpl implements PracticeService {
	@Autowired
	private PracticeDao practicedao;
	
	@Override
	public String SayHello(String s) {
		// TODO Auto-generated method stub
		return practicedao.sayHello(s);
	}
	
}

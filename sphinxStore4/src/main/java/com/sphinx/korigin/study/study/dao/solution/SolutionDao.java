package com.sphinx.korigin.study.study.dao.solution;

import java.util.List;

import com.sphinx.korigin.study.study.domain.solution.Solution;

public interface SolutionDao {

	public void createSolution(Solution sol);

	public List<Solution> findAllSolutions();

	public Solution findSolution(String solid);

	public Solution findSolutionOfQuestion(String qid);

	public void updateSolution(Solution sol);

}

package pack;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A couple of questions related to an Internship as Software Engineer
 * 
 * @author Vagner Machado - September 2019
 *
 */
class solution {

	/**
	 * Array input provides heights of students. Being that students arrive 
	 * in order from a[0] ... a[n] determined the least number of lines needed given 
	 * a student can only stand behind someone taller. If none is taller, make a new line.
	 * @param A
	 * @return the minimum number of lines to accomodate the students
	 */
	static int solutionHeight(Integer[] A) {
		// Your solution goes here.
		int rows = 1;
		int maxHeight = A[0];
		ArrayList<Integer> tails = new ArrayList<Integer>();
		tails.add(A[0]);
		for (int i = 1; i < A.length; i++)
		{
			//new row 
			if(A[i] > maxHeight)
			{
				maxHeight = A[i];
				rows++;
				tails.add(A[i]);
			}
			//look for existing row
			else {
				boolean hasTail = false;
				for(int j = A[i] + 1; j <= maxHeight && hasTail == false; j++)
				{
					if(tails.contains(j))
					{
						tails.remove((new Integer(j)));
						hasTail = true;
						tails.add(new Integer(A[i]));
					}
				}
				//force new row
				if(hasTail == false)
					rows++;
			}
		}
		return rows;
	}

	/**
	 * Given an array of integers representing the weight of tasks to be executed, distribute tasks as 
	 * evenly as possible between two processors and return minimum weight difference between them.
	 * @param A - array on int represent the cost/weight of each tasks
	 * @return load on processr A - load on processor B
	 */
	static int solutionProcesses(Integer [] A)
	{
		Arrays.sort(A);
		int one = A[A.length - 1];
		int two = A[A.length - 2];
		int right = A.length - 3;

		while(right > -1)
		{
			if(one >= two)
			{
				while(one >= two)
				{
					two += A[right--];
					if (right < 0)
						break;
				}
			}
			else
			{
				while(one < two)
				{
					one += A[right--];
					if (right < 0)
						break;
				}
			}
		}
		return Math.abs(one - two);
	}
	public static void main(String[] args) {
	
		Integer[] A = {4, 5, 4, 3, 6, 1, 8, 15, 12, 11, 3};
		Integer[] B = {80,5,4,12,72,3,1,1};
		System.out.println("The least number of lines is " + solutionHeight(A));
		System.out.println("The processor weight difference is " + solutionProcesses(B));
		
	}	
}
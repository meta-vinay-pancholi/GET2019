

import java.util.Scanner;


public class JobScheduler {
	/**
	 * @param jobs
	 * @param numberOfJobs
	 * function returning completion time for the given jobs
	 */
	public int[] completionTime(int jobs[][], int numberOfJobs){
		int completionTime[]=new int[numberOfJobs];
		int sum=0;
		for(int i=0;i<numberOfJobs;i++){
			sum=sum+jobs[i][1];
			completionTime[i]=sum;//Completion time is sum of burst time
		}
		return completionTime;
	}
	
	/**
	 * @param jobs
	 * @param numberOfJobs
	 * @param completionTime
	 * function returning turn around time
	 */
	public int[] turnAroundTime(int jobs[][],int numberOfJobs, int completionTime[]){
		int turnAroundTime[]=new int[numberOfJobs];
		for(int i=0;i<numberOfJobs;i++){
			turnAroundTime[i]=completionTime[i]-jobs[i][0];//turn around time = completion time - arrival time
		}
		return turnAroundTime;
	}
	
	/**
	 * @param jobs
	 * @param numberOfJobs
	 * @param turnAroundTime
	 * function returning  waiting time for given jobs
	 */
	public int[] waitingTime(int jobs[][],int numberOfJobs,int turnAroundTime[]){
		int waitingTime[]=new int[numberOfJobs];
		for(int i=0;i<numberOfJobs;i++){
			waitingTime[i]=turnAroundTime[i]-jobs[i][1];//waiting time = turn around time - burst time
		}
		return waitingTime;
	}




}


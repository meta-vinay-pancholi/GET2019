import java.util.Scanner;


/**
 * @author Admin
 *
 */
public class MainBody {
	
	public static void main(String args[]){
		
		JobScheduler js=new JobScheduler();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of jobs\n");//enter number of jobs
		int numberOfJobs=sc.nextInt();
		int jobs[][]=new int[numberOfJobs][2];
		for(int i=0;i<numberOfJobs;i++){
			System.out.println("Enter arrival time for "+ (i+1) +" job");//Assume jobs in sorted order
			jobs[i][0]=sc.nextInt();//0 index holding arrival
			System.out.println("Enter burst time for "+ (i+1) +" job");//Assume jobs in sorted order
			jobs[i][1]=sc.nextInt();//1 index holding burst time
		}
		int compTime[]=js.completionTime(jobs, numberOfJobs);
		int turnTime[]=js.turnAroundTime(jobs, numberOfJobs, compTime);
		int waitTime[]=js.waitingTime(jobs, numberOfJobs, turnTime);
		System.out.println("process\t\tArrival Time\tBurst Time\tWaiting Time\tTurnAround Time\t\tCompletion Time");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		int totalWaitingTime = 0;
		for(int i=0; i < numberOfJobs; i++) {
			totalWaitingTime += waitTime[i]; 
			System.out.println("  "+ (i + 1) +"\t\t    "+jobs[i][0]+"\t\t    "+jobs[i][1]+"\t\t    "+waitTime[i]+"\t\t    "+turnTime[i]+"\t\t\t    "+compTime[i]);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Average waiting time = " + (float)totalWaitingTime / (float)numberOfJobs);//Average waiting time=(Total waiting time/number of jobs)
		int max = waitTime[0];
		for(int j = 1; j < numberOfJobs; j++) {
			if(max < waitTime[j])
				max = waitTime[j];
		}
		System.out.println("Maximum waiting time period for a process in queue = " + max);


	}

}

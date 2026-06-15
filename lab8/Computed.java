package lab8;
import java.math.*;
public class Computed extends Thread{
	public int n;
	BigInteger result;
	BigInteger sum;
	String str="";
	ReturnInfor returnInfor;
	boolean isStop=false;
	public Computed(int n)
	{
		this.n=n;
	}
	private void Computing()
	{
		result=BigInteger.valueOf(0);
		sum=BigInteger.valueOf(1);
		for(int i=1;i<=n;i++)
		{
			sum=sum.multiply(BigInteger.valueOf(i));
			result=result.add(sum);
			str=str+(i==1?"":"+")+i+"!";
//			System.out.println(str+"="+result);
			try {
				Thread.sleep((int)(Math.random()*500+500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.isStop=true;
	}
	public void run () {
		this.Computing();
	}
	
}

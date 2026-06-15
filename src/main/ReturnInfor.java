package main;

public class ReturnInfor implements Runnable{
	Computed computed;
	ComputAble computAble;
	 private volatile boolean running = true;
	ReturnInfor (Computed computed,ComputAble computAble)
	{
		this.computed=computed;
		this.computAble=computAble;
	}
	public void read(){
		try {
			Thread.sleep(1000);
			computAble.log(computed.str,computed.result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		while(running)
		{
			if(computed.isStop==true)
			{
				break;
			}
			read();
		}
	}
	
}

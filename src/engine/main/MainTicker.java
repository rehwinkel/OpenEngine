package engine.main;

public class MainTicker extends Thread{
	
	private double mills;
	private Runner runner;
	
	public MainTicker(Runner runner){
		this.runner = runner;
		int tps = Runner.TPS;
		this.mills = 1000D/tps;
	}
	
	@Override
	public void run(){
		long start = System.currentTimeMillis();
		while(true){
			long now = System.currentTimeMillis();
			while(now+mills > start){
				start = System.currentTimeMillis();
			}
			tick();
		}
	}

	private void tick() {
		runner.tick();
	}
}

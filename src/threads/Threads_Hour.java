package threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.Logic_View_Home;

public class Threads_Hour extends Thread{

	private Logic_View_Home lvh;
	private LocalDateTime ahora;
	private DateTimeFormatter formatter;
	private String fechaActual;
	private boolean run = true;
	
	public Threads_Hour(Logic_View_Home lvh)
	{
		this.lvh = lvh;
	}
	
	
	public void detener()
	{
		run = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(run)
		{
			this.ahora  = LocalDateTime.now();
			this.formatter = DateTimeFormatter.ofPattern("EEEE, dd LLLL yyyy HH:mm:ss"); 
			this.fechaActual  = this.ahora.format(this.formatter);
			this.fechaActual = Character.toUpperCase(this.fechaActual.charAt(0)) + this.fechaActual.substring(1);
			this.lvh.vh.fecha_label.setText(this.fechaActual);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

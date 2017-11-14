package com.parx.sample.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start-up" );        
        try {
            // Grab the Scheduler instance from the Factory
            final Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();            
			Runtime.getRuntime().addShutdownHook(new Thread()
			{
				@Override
				public void run()
				{					
					System.out.println("App shutting down.");
					if (scheduler != null) 
					{
						try 
						{
							scheduler.shutdown();
						} 
						catch (SchedulerException e) 
						{
							e.printStackTrace();
						}
					}
				}		
			});
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                
        
    }
}

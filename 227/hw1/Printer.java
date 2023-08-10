package hw1;

import java.lang.Math;

/**
 * 
 * @author aryan
 * Class Printer
 * Creates a real life model of a working printer 
 * Contains many features like starting to print, removing and adding papers, replacing tray
 * Also has many basic methods for returning instance variables
 *
 */

public class Printer {
	
		 
		
	    
	    /**
	      * noOfSheets - number of sheets in tray
	      * maxSheets - Maximum number of sheets that the tray can hold
	      * nextPage - Next page to print from 0 to (n-1)
	      * pagesToPrint - Number of pages to print in a single document
	      * totalPages - Total pages printed since the construction of the printer
	      * sheetsAvaialable - Sheets available for the printer 
	    */
	    private int noOfSheets;
	    
	    private int maxSheets;
	    
	    private int nextPage;
	    
	    private int pagesToPrint;
	    
	    private int totalPages;
	    
	    private int sheetsAvailable;
	   
	    
	    
	    /**
	     * Initialises the maximum number of sheets with the parameter trayCapacity
	     * Also initialises all remaining instance variables to 0  
	     * @param trayCapacity - Maximum number of sheets the printer can hold
	     */

		public Printer(int trayCapacity)
		{
			
			maxSheets = trayCapacity;
			
			noOfSheets = 0;
			
			nextPage=0;
			
			pagesToPrint=0;
			
			totalPages=0;
			
			sheetsAvailable = 0;
			
		}
		
		
		
		/**
		 * Sets the variable pagesToPrint equal to the parameter documentPages
		 * Sets the variable nextPage to 0
		 * @param documentPages - Total pages to print in a single document
		 */

		public void startPrintJob(int documentPages)
		{
		    pagesToPrint = documentPages;
			 
			nextPage = 0;
		}
		
		
		
		/**
		 * Returns the sheets available
		 * @return - sheetsAvailable
		 */

		public int getSheetsAvailable()
		{
			
			return sheetsAvailable;
		
		}
		
		

		/**
		 * Returns the next page to be printed
		 * @return - nextPage
		 */
		
		public int getNextPage()
		{
		    
			return nextPage;
		}
		
		
       
		/**
		 * Returns the total number of pages printed since the construction of printer
		 * @return - totalPages 
		 */
		
		public int getTotalPages()
		{
		
			return totalPages;
		}
		
		

		/**
		 * Introducing two temporary variables for wrapping around to 0 when document is printed 
		 * Increments total number of sheets available
		 * Increments the next page supposed to be printed
		 * When a document is printed, nextPage wraps around to 0
		 * Decreases sheetsAvailable after a sheet is printed
		 * Decreasing number of sheets in tray
		 */
		
		public void printPage()
		{
			int tempVar1 = Math.max(0,sheetsAvailable);
			
			int tempVar2= Math.min(1,tempVar1);
			
			totalPages+=tempVar2;
			
			sheetsAvailable-=tempVar2;
			
			nextPage+=tempVar2;
			
			nextPage=nextPage%pagesToPrint;
			
		}
		
		

		/**
		 * Since tray is removed, sheetsAvailable becomes 0 as no sheets are available to print
		 */
		
		public void removeTray()
		{
			noOfSheets = sheetsAvailable;
			
			sheetsAvailable = 0;
		}
		
		

		/**
		 * Since tray is removed, sheets available is number of sheets in tray
		 */
		
		public void replaceTray()
		{
			
			sheetsAvailable = noOfSheets;
			
		}
		
		

		/**
		 * Increases number of sheets by the sheets parameter passed
		 * Since tray is removed, sheets available is number of sheets in tray
		 * Does not allow sheets to go above the maximum number of sheets
		 * @param sheets - number of sheets added by the user
		 */
		
		public void addPaper(int sheets)
		{
			
		    noOfSheets+=sheets;
			
			sheetsAvailable = noOfSheets;
			
			sheetsAvailable= Math.min(sheetsAvailable,maxSheets);
			
		}
		
		

		/**
		 * Decreases number of sheets by the sheets parameter passed
		 * Since tray is removed, sheets available is number of sheets in tray
		 * Does not allow sheets to go below 0
		 * @param sheets - number of sheets removed by the user
		 */
		
		public void removePaper(int sheets)
		{
			
			noOfSheets-=sheets;
			
			sheetsAvailable = noOfSheets;
			
			sheetsAvailable = Math.max(sheetsAvailable,0);
			
		}
		
}



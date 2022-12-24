/**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.Comparator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class will update the front-end. It will create
 * a window with 9 total buttons, so a user could choose
 * the format they want to view the data in. It will by having
 * a field of influencers that will be constantly changed
 * based on the current button's pressed. There will also be a
 * Double array that will store the engagement values for a specific
 * order of the influencers list which will determine the height
 * of the bars displayed. To keep tabs on what buttons
 * are pressed, 3 String fields will be updated
 * (month, engagementRate, sortBy) based on what buttons have been
 * pressed. These strings will be checked in if-Statements throughout
 * the class to obtain the proper output.
 * 
 * @author Andrei Zaitsev
 * @version 11/30/22
 * @author Mason Dooley
 * @version 12/2/2022
 */
public class SocialMediaWindow {

    //Fields
    private LinkedList<Influencer> influencers;
    private Double[] currRates;
    private Window window;
    private String engagementRate;
    private String month;
    private String sortBy;

    public SocialMediaWindow(LinkedList<Influencer> influencers) {
       
        //Store fields
        this.influencers = influencers;
        
        //Create window
        window = new Window();
        window.setTitle("Social Media Vis");
        
        //Create Sort by ChannelName button
        Button sortCN = new Button("Sort by Channel Name");
        sortCN.onClick(this, "clickedSortName");
        window.addButton(sortCN, WindowSide.NORTH);
        
        //Create Sort by Engagement Rate button
        Button sortER = new Button("Sort by Engagement Rate");
        sortER.onClick(this, "clickedSortRate");
        window.addButton(sortER, WindowSide.NORTH);
        
        //Create quit button
        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        
        //Create January button
        Button jan = new Button("January");
        jan.onClick(this, "clickedJanuary");
        window.addButton(jan, WindowSide.SOUTH);
        
        //Create February button
        Button feb = new Button("February");
        feb.onClick(this, "clickedFebruary");
        window.addButton(feb, WindowSide.SOUTH);
        
        //Create March button
        Button mar = new Button("March");
        mar.onClick(this, "clickedMarch");
        window.addButton(mar, WindowSide.SOUTH);
        
        //Create quarter button
        Button quarter = new Button("First Quarter (Jan - March)");
        quarter.onClick(this, "clickedQuarter");
        window.addButton(quarter, WindowSide.SOUTH);
        
        //Create Traditional Engagement Rate button
        Button trdEng = new Button("Traditional Engagement Rate");
        trdEng.onClick(this, "clickedTraditional");
        window.addButton(trdEng, WindowSide.WEST);
        
        //Create Reach Engagement Rate button
        Button reachEng = new Button("Reach Engagement Rate");
        reachEng.onClick(this, "clickedReach");
        window.addButton(reachEng, WindowSide.WEST);
        
        //Create Double array that will store engagement rate values
        currRates = new Double[influencers.size()];

        //Initial state of the window when it is opened
        engagementRate = "Traditional Engagement Rate";
        month = "January";
        sortBy = "Sorting By Channel Name";
        
        //Update front-end
        clickedJanuary(jan);
    }


    /**
     * Method for displaying information based on settings. Will add
     * text and bars with a height that is based off of the
     * current order of the influencers list and the current
     * state of the Double array currRates
     */
    private void display() {
        
        //Clear window
        window.removeAllShapes();
        
        //Round numbers to one decimal place
        roundAllNumbers();
        
        //Textshapes will be added based on the current status of the
        //desired month, engagementRate and sortBy (String fields)
        TextShape timePeriod = new TextShape(10, 7, month);
        window.addShape(timePeriod);
        TextShape rateType = new TextShape(10, 27, engagementRate);
        window.addShape(rateType);
        TextShape sorting = new TextShape(10, 47, sortBy);
        window.addShape(sorting);
        
        //Setting a barwidth
        int width = 40;
        
        //Loop through influencers
        for (int i = 0; i < influencers.size(); i++) {
            
            //Check if the current rate is 0.0. Will require
            //an N/A string to be created and added
            if (Math.abs(currRates[i]) <= .00001) {
                
                int height = (int)(0.0);
                Color color = influencers.get(i).getColor();
                Shape bar = new Shape(width + i*300, 80 + (520 - height), width, height,
                    color);
                window.addShape(bar);
                TextShape name = new TextShape(width + i*300, 625, influencers.get(i)
                    .getChannelInfo().getChannelName());
                window.addShape(name);
                String engRateStr = "N/A";
                TextShape rate = new TextShape(width + i*300, 655, engRateStr);
                window.addShape(rate);
            }
            
            else {
                
                //Get the proper engagement Rate
                double engRate = currRates[i];
                
                //Create a height based on engagement Rate size
                int height = (int)(engRate * 3);
                
                //Get influencer color
                Color color = influencers.get(i).getColor();
                
                //Create a bar. X-coordinate is determined on current i value.
                //Y-coordinate is determined on height.
                Shape bar = new Shape(width + i*300, 80 + (520 - height), width, height,
                    color);
                window.addShape(bar);
                
                //Get influencer channelName and create a textShape with it
                TextShape name = new TextShape(width + i*300, 625, influencers.get(i)
                    .getChannelInfo().getChannelName());
                window.addShape(name);
                
                //Create a textShape based off of the engagement Rate
                String engRateStr = String.valueOf(engRate);
                TextShape rate = new TextShape(width + i*300, 655, engRateStr);
                window.addShape(rate);
            }
        }

    }


    /**
     * Method for when quit is clicked. 
     * Exits the screen
     * 
     * @param button Quit
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * Method for when January is clicked. Will update the month String
     * then check the desired sort and call
     * a private helper method and sort
     * 
     * @param button January
     */
    public void clickedJanuary(Button button) {
        
        //Update String
        month = "January";
        
        //Check Desired Sort
        if (sortBy.equals("Sorting By Engagement Rate")) {
            
            quickMonthRateSort();
        }
        
        else {
            quickNameSort();
        }
    }
    
    /**
     * Method for when February is clicked. Will update the month String
     * then check the desired sort and call
     * a private helper method and sort
     * 
     * @param button February
     */
    public void clickedFebruary(Button button) {
        
        //Update String
        month = "February";
        
        //Check desired sort
        if (sortBy.equals("Sorting By Engagement Rate")) {
            
            quickMonthRateSort();
        }
        
        else {
            quickNameSort();
        }
    }
    
    /**
     * Method for when March is clicked. Will update the month String
     * then check the desired sort and call
     * a private helper method and sort
     * 
     * @param button March
     */
    public void clickedMarch(Button button) {
        
        //Update String
        month = "March";
        
        //Check desired sort
        if (sortBy.equals("Sorting By Engagement Rate")) {
            
            quickMonthRateSort();
        }
        
        else {
            
            quickNameSort();
        }
    }
    
    /**
     * Method for when the first quarter button is 
     * clicked. Will update the desired month string
     * and check what the desired sort it
     * 
     * @param button First Quarter (Jan - March) 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void clickedQuarter(Button button) {
        
        //Update Sting
        month = "First Quarter (Jan - March)";
        
        //Check desired sort
        if (sortBy.equals("Sorting By Channel Name")) {
            quickNameSort();
        }
        
        //Desired sort is Engagement Rate, so check the desired
        //engagement rate and sort
        else if (engagementRate.equals("Traditional Engagement Rate")) {
            Comparator comparator = new CompareByTraditionalQuarter();
            influencers = influencers.sortList(comparator, influencers);
            setCurrRatesQuarter();
        }
        
        else {
            
            Comparator comparator = new CompareByReachQuarter();
            influencers = influencers.sortList(comparator, influencers);
            setCurrRatesQuarter();
        }
    }
    
    /**
     * Method for when Traditional is clicked. Will update
     * the engagementRate String and then check what the 
     * desired sort is. 
     * 
     * @param button Traditional Engagement Rate
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void clickedTraditional(Button button) {
        
        //Update String
        engagementRate = "Traditional Engagement Rate";
        
        //Check desired sort
        if (sortBy.equals("Sorting By Engagement Rate")) {
            
            //Check desired month and sort
            if (month.equals("First Quarter (Jan - March)")) {
                
                Comparator comparator = new CompareByTraditionalQuarter();
                influencers = influencers.sortList(comparator, influencers);
                setCurrRatesQuarter();
            }
            
            else {
                
                Comparator comparator = new CompareByTraditionalEngagementMonth(month);
                influencers = influencers.sortList(comparator, influencers);
                setCurrRatesMonth();
            }
        }
        
        else {
            
            quickNameSort();
        }
    }
    
    /**
     * Method for when Reach is clicked. Will update the
     * engagementRate String and then check if the desired
     * sort is Engagement Rate or Name and sort.
     * 
     * @param button Reach Engagement Rate Button
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void clickedReach(Button button) {
        
        engagementRate = "Reach Engagement Rate";
        
        //Check desired sort
        if (sortBy.equals("Sorting By Engagement Rate")) {
            
            //Check desired month
            if (month.equals("First Quarter (Jan - March)")) {
                
                Comparator comparator = new CompareByReachQuarter();
                influencers = influencers.sortList(comparator, influencers);
                setCurrRatesQuarter();
            }
            
            else {
                
                Comparator comparator = new CompareByReachEngagementMonth(month);
                influencers = influencers.sortList(comparator, influencers);
                setCurrRatesMonth();
            }
        }
        
        //Sort by Name
        else {
            
            quickNameSort();
        }
    }
    
    /**
     * Will update the sortBy String and then call the
     * quickNameSort() method which will handle the sorting
     * 
     * @param button Sort By Channel Name button
     */
    public void clickedSortName(Button button) {
        
        sortBy = "Sorting By Channel Name";
        quickNameSort();
    }
    
    /**
     * This method is activated when the Sort By Engagement
     * Rate button is hit. Will first update the sortBy string then
     * check if the desired month is a quarter or a singular month.
     * Will then check what the desired rate is and sort the influencers
     * by that rate. Will then call the proper setCurrRates method
     * (depending on if Quarter or month).
     * 
     * @param button Sort By Engagement Rate
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void clickedSortRate(Button button) {
        
        sortBy = "Sorting By Engagement Rate";
        
        if (month.equals("First Quarter (Jan - March)")) {
            
            if (engagementRate.equals("Reach Engagement Rate")) {
                
                Comparator comparator = new CompareByReachQuarter();
                influencers = influencers.sortList(comparator, influencers);
            }
            
            else {
                
                Comparator comparator = new CompareByTraditionalQuarter();
                influencers = influencers.sortList(comparator, influencers);
            }
            
            setCurrRatesQuarter();
        }
        
        else {
            
            if (engagementRate.equals("Reach Engagement Rate")) {
                
                Comparator comparator = new CompareByReachEngagementMonth(month);
                influencers = influencers.sortList(comparator, influencers);
            }
            
            else {
                Comparator comparator = new CompareByTraditionalEngagementMonth(month);
                influencers = influencers.sortList(comparator, influencers);
            }  
            
            setCurrRatesMonth();
        }
    }
    
    /**
     * This method sets the Double of Engagement rates for a
     * quarter (Not Month) and calls Display to update the front-end.
     * Will check what the current desired form of
     * engagementRate is
     */
    private void setCurrRatesQuarter() {
        
        int counter = 0;
        
        //Check desired Engagement Rate
        if (engagementRate.equals("Traditional Engagement Rate")) {
            
            //Loop through entries
            for (Influencer in: influencers) {
            
                //Get quarter engagement and add to array
                Engagement engagement = in.getEngagementForQuarter();
                currRates[counter] = engagement.getTraditionalEngagement();
                counter++;
            }
        }
          
        //Desired rate is reach
        else {
            
            for (Influencer in: influencers) {
                
                Engagement engagement = in.getEngagementForQuarter();
                currRates[counter] = engagement.getReachEngagement();
                counter++;
            }
        }
        
        //Update Front End
        display();
    }
    
    /**
     * This method sets the Double of Engagement rates for a
     * month (Not Quarter) and calls Display to update the front-end.
     * If an influencer has a null engagement for a specific month
     * then currRates will assign that value as 0.0 and N/A will
     * be displayed. Will check what the current desired form of
     * engagementRate is
     */
    private void setCurrRatesMonth() {
        
        int counter = 0;
        
        //Check Engagement Rate
        if (engagementRate.equals("Traditional Engagement Rate")) {
                
            //Loop through list
            for (Influencer in: influencers) {
                
                //Check if Engagement is null
                if (in.getEngagement(month) == null) {
                    
                    currRates[counter] = 0.0;
                }
                
                else {
                
                    //Get the correct Engagement and store in the array
                    currRates[counter] = in.getEngagement(month).
                        getTraditionalEngagement();
                }
                
                counter++;
            }
        }
            
        //Desired Engagement Rate is Reach
        else {
            
            for (Influencer in: influencers) {

                if (in.getEngagement(month) == null) {
                    
                    currRates[counter] = 0.0;
                }
                
                else {
                    
                    currRates[counter] = in.getEngagement(month).
                        getReachEngagement();
                }
                
                counter++;
            }
        }
        
        //Update front-end
        display();
    }
    
    /**
     * This method will sort the current month (Not used for quarters)
     * by the correct Engagement Rate
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void quickMonthRateSort() {
        
        if (engagementRate.equals("Traditional Engagement Rate")) {
            
            Comparator comparator = new CompareByTraditionalEngagementMonth(month);
            influencers = influencers.sortList(comparator, influencers);
            setCurrRatesMonth();
        }
        
        else {
            
            Comparator comparator = new CompareByReachEngagementMonth(month);
            influencers = influencers.sortList(comparator, influencers);
            setCurrRatesMonth();
        }
    }
    
    /**
     * This private method will sort the Influencers by name.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void quickNameSort() {
        
        //Create comparator and sort
        Comparator comparator = new CompareByChannelName();
        influencers = influencers.sortList(comparator, influencers);
        
        if (month.equals("First Quarter (Jan - March)")) {
            
            setCurrRatesQuarter();
        }
        
        else {
            
            setCurrRatesMonth();
        }
    }
    
    /**
     * This private method adjusts the Double[] array of 
     * currRates so that each number is rounded to a singular
     * decimal place before display
     */
    private void roundAllNumbers() {
        
        for (int i = 0; i < currRates.length; i++) {
            
            currRates[i] = Math.round(currRates[i]*10.0)/10.0;
        }
    }
}


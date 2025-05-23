package tv;

public class TVLogic {
	 // constants
    public final static int MAX_CHANNEL = 30;
    public final static int MIN_CHANNEL = 1;
    public final static float MAX_VOLUME  = 1;
    public final static float MIN_VOLUME  = 0.1f;
    public final static int DEFAULT_CHANNEL = 1;
    public final static int DEFAULT_VOLUME  = 5;
    
    // instance variables
    private static int channel = DEFAULT_CHANNEL;
    private static int volume = DEFAULT_VOLUME;
    
    //Screw Constructors, Static chads rise up
    // accessor methods
   static public int getChannel()
    {
       return channel; 
    }
    
    static public int getVolume()
    {
        return volume;
    }
	
    // mutator methods
	
    /* This method increases the channel by one.
     * If the channel increase exceeds the value of MAX_CHANNEL
     * then the channel should be set to MIN_CHANNEL.
     */
    public static void increaseChannel() 
    {
    	if(channel + 1 > MAX_CHANNEL) {
        	channel = MIN_CHANNEL;
        } else {
        	channel++;
        }
    }
    
    /* This method decreases the channel by one.
     * If the channel decrease exceeds the value of MIN_CHANNEL
     * then the channel should be set to MAX_CHANNEL.
     */
    public static void decreaseChannel()
    {
        if(channel - 1 < MIN_CHANNEL) {
        	channel = MAX_CHANNEL;
        } else {
        	channel--;
        }
    }
    
    /* This method changes the channel to the value specified
     * in the parameter list. If the value of the parameter is 
     * not a valid channel number then the channel should 
     * remain unchanged.
     * @param c the channel to be changed to
     */
    public static void selectChannel(int c)
    {
       if(!(c > MAX_CHANNEL || c < MIN_CHANNEL)) {
    	   channel = c; 
       }
    }
    
    /* This method increases the volume by one.
     * If MAX_VOLUME is reached a call to increaseVolume 
     * should have no effect.
     */
    public static void increaseVolume()
    {
        if(!(volume + 1 > MAX_VOLUME)) {
        	volume++;
        }
    }
    
    /* This method decreases the volume by one.
     * If MIN_VOLUME is reached a call to decreaseVolume 
     * should have no effect.
     */
    public static void decreaseVolume()
    {
    	if(!(volume - 1 < MIN_VOLUME)) {
    		volume--;
        }
    }

}

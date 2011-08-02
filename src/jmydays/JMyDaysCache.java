/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jmydays;


/**
 *
 * @author Administrator
 */
public class JMyDaysCache implements java.io.Serializable, JMyDaysConstants {

	private static final long serialVersionUID = -1261987050619840419L;
	
	public int currentTextPaneFontSize = 12;
    public String labelsActArr[] = new String[ACTV_ROW_NUM_MAX];
    public int labelsActIdArr[] =  new int[ACTV_ROW_NUM_MAX];

    public String defSavedLang = "";

    private java.awt.Dimension appDimensions = new java.awt.Dimension(APP_SIZE_NOT_INITIALIZED, APP_SIZE_NOT_INITIALIZED);

    private java.awt.Dimension screenDimensions = new java.awt.Dimension(APP_SIZE_NOT_INITIALIZED, APP_SIZE_NOT_INITIALIZED);
    
    private java.awt.Point appMainScreenLocation = new java.awt.Point(); //0,0
    
    private boolean usingPassword = false;
    
    /**
     * @return the appDimensions
     */
    public java.awt.Dimension getAppDimensions() {
        return appDimensions;
    }

    /**
     * @param appDimensions the appDimensions to set
     */
    public void setAppDimensions(java.awt.Dimension appDimensions) {
        this.appDimensions = appDimensions;
    }

	public void setAppMainScreenLocation(java.awt.Point appMainScreenLocation) {
		this.appMainScreenLocation = appMainScreenLocation;
	}

	public java.awt.Point getAppMainScreenLocation() {
		return appMainScreenLocation;
	}

	public void setScreenDimensions(java.awt.Dimension screenDimensions) {
		this.screenDimensions = screenDimensions;
	}

	public java.awt.Dimension getScreenDimensions() {
		return screenDimensions;
	}

	public void setUsingPassword(boolean usingPassword) {
		this.usingPassword = usingPassword;
	}

	public boolean isUsingPassword() {
		return usingPassword;
	}


}

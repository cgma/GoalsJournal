/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jmydays;

/**
 * Helps to avoid use of "magic numbers".
 * @author CGMA
 */
public interface JMyDaysConstants {

    int TEXTFIELD_COL_SIZE = 6;

    String SDF_DAY_PATTERN_1 = "EEEE d"; //Day_of_week  #Day_in_Month (e.g.: "Monday 19")

    String SDF_MONTH_PATTERN_1 = "MMMM yyyy"; //

    String DB_DATE_PKEY_PATTERN = "yyyy-MM-dd";

    String CONFIGS_FILENAME = "configs.dat";

    int TODAY_TEXTPANE_NUM = 1;

    int DIM_ACTV_LABEL_MAX_X = 250;
    int DIM_ACTV_LABEL_DEFAULT_X = 105;
    int DIM_ACTV_LABEL_DEFAULT_Y = 20;

    int DIM_ACTV_TXTFLD_DEFAULT_X = 35;
    int DIM_ACTV_TXTFLD_DEFAULT_Y = 20;

    int DIM_ACTV_SLIDER_DEFAULT_X = 180;
    int DIM_ACTV_SLIDER_DEFAULT_Y = 20;

    int DIM_TXTPANE_DEF_X = 180;
    int DIM_TXTPANE_DEF_Y = 100;

//    int DIM_BTN_DEF_X = 40;
//    int DIM_BTN_DEF_Y = 20;

    int DIM_ACTV_CONF_DIALOG1_X = 260; //Extra 20 to fit fine in cross-plataform Look and Feel.
    int DIM_ACTV_CONF_DIALOG1_Y = 240;

    int COMPONENT_TYPE_DEFAULT = 1;
    int COMPONENT_TYPE_TEXTFIELD = 0;
    int COMPONENT_TYPE_CHECKBOX = 1;
    int COMPONENT_TYPE_SLIDER = 2;

    String DELIM_LANGS = ",";

    String DELIM_COMPONENT_TYPE = ",";

    String ACTV_VAL_DELIM_STR_REGEX = "\\|"; //IMPORTATN! Character PIPE ("|") requires being escaped, if this value is changed to other that doesn't need being escaped (e.g.: "*") be sure to remove "\\"
    
    String ACTV_VALUE_DELIM_STR = "|";
    
    String ACTV_CB_CHECKED_VAL = "1";
    String ACTV_CB_UNCHECKED_VAL = "0";
    

    String ACTV_TXTFLD_EMPTY_VAL = "0";
    String ACTV_TXTFLD_UNINIT_VAL = "";

    int ACTV_CAT_UNSPECIFIED_ID = -1;

    int INSETS_SEP_A_FULL = 5;
    int INSETS_SEP_A_HALF = 5/2;

    int APP_SIZE_NOT_INITIALIZED = 0;

    int APP_SIZE_RECOMMENDED_MIN_HEIGHT = 580;
    int APP_SIZE_RECOMMENDED_MIN_WIDTH = 900;
    
    int APP_SIZE_HEIGHT_MIN = 480;
    int APP_SIZE_WIDTH_MIN = 640;

    int ACTV_ROW_NUM_MIN = 0;
    int ACTV_ROW_NUM_MAX = 9; //Maximim number of existing activity rows, if incresed, components must also be incresed.
    int ACTV_ROW_NUM_INIT_VAL = -1;

    int ACTV_DISP_DAYS = 3;

    String DATE_RANGE_WILDCARD = "*";
    
    String DATE_RANGE_CURRENT_DATE = "";

    String ABOUT_MSG = "Thanks for your interest in Goals Journal (originally JMyDays)! \n" +
                                "This application is based on: www.joesgoals.com \n\n" +
                                "This application is distributen under the GNU General Public License. \n" +
                                "(Available at: http://www.gnu.org/licenses/gpl.html). \n\n" +
                                "Coding by Carlos G. Marin Amador \n" +
                                "Contact: ing.cma AT gmail DOT com \n\n" +
                                "GoalsJournal version ";


    int ROLL_1_DAY_BACK = -1;
    int ROLL_1_DAY_FRWR = 1;
    int DAYS_TO_ROLL_TODAY = 0;
    int DAYS_TO_ROLL_NONE = 0;

    String DAYS_TO_ROLL_PREV1_STR = "-1";
    String DAYS_TO_ROLL_TODAY_STR = "0";
    String DAYS_TO_ROLL_FRWR1_STR = "1";


    int ACTV_SLIDER_MIN_VAL = 0;
    int ACTV_SLIDER_MAX_VAL = 10;

    int ACTV_SLIDER_MIN_TICK_SPACE = 1;
    int ACTV_SLIDER_MAX_TICK_SPACE = 10;

    int ACTV_TEXTFIELD_MAX_INPUT = 7;

    String LAF_NONE = "-1";

    java.awt.Color MISSMATCH_COMP_COLOR = java.awt.Color.LIGHT_GRAY;

    int MOUSE_DOUBLE_CLICK = 2;

//    int TYPED_HISTORY_REG_CHAR_INTERVAL = 5;
    int TYPED_HISTORY_REG_CHAR_MAX_LENGTH = 5000;
    int TYPED_HISTORY_REG_NUM_MAX = 25;
    String TYPED_HISTORY_REDO_POSTFIX = "r";

    java.awt.Color CURRENTLY_ACTIVE_COLOR = java.awt.Color.BLUE;
    
    java.awt.Color ZERO_ADVANDE_COLOR = new java.awt.Color(215, 43, 43);
    java.awt.Color NON_ZERO_ADVANDE_COLOR = new java.awt.Color(0, 150, 0) ;

    String DB_TRUE_CHAR = "Y";
    String DB_FALSE_CHAR = "N";
    
    int PASS_LENGTH_MIN = 8;
    
    String EMPTY_STRING = ""; 
    String EMPTY_PASS_STRING = "";
    
    int PASS_REQUEST = 0;
    int PASS_STATE_CHANGE = 1;
    
    int LABELS_PER_LINE = 3; //Used when displaying existing labels
    
    String INSTANCE_LOCK_FILENAME = "~GoalsJournal.temp";
    
    String PROPS_CONFIG_FILENAME = "config.properties";
    String DB_FILENAME = "GoalsJournalDB.s3db";
    
    int OS_WINDOWS = 1;
    int OS_MAC = 2;
    int OS_LINUX = 3;
    
    enum OS{ WINDOWS, MAC, LINUX, UNKNOWN };
    

}

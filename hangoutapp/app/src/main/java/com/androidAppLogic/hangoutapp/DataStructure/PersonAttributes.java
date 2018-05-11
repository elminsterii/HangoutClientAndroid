package com.androidAppLogic.hangoutapp.DataStructure;

public class PersonAttributes {

    private int m_age;					    //年紀 (必填)
    private String m_gender;			    //性別 (Male\Female) (必填)
    private String m_email;		            //mail (account) (必填) (主Key)
    private String m_userpassword;		    //password (必填)
    private String m_displayname;			//暱稱 (必填)
    private String m_icon;				    //Icon
    private String m_description;		    //個人介紹
    private String m_location;			    //所在地區
    private String[] m_interests;		    //興趣Tag
    private String[] m_joinactivities;		//現在參加的活動
    private String[] m_holdactivities;		//現在舉辦的活動
    private String[] m_saveactivities;		//現在保存的活動
    int m_goodmember;				        //好團員指數
    int m_goodleader;				        //好團長指數
    int m_online;			                //是否上線(1 = online)(預設0)

    public  PersonAttributes(String sEmail, String sPwd, String sGender, String sName, int iAge){
        m_email = sEmail;
        m_userpassword = sPwd;
        m_displayname = sName;
        m_gender = sGender;
        m_age = iAge;
    }

    public String getEmail(){
        return  m_email;
    }
    void setEmail(String sEmail){
        m_email  = sEmail;
    }

    public String getPassword(){
        return  m_email;
    }
    void setPassword(String sPwd){
        m_userpassword  = sPwd;
    }

    public String getName(){
        return  m_displayname;
    }
    void setName(String sName){
        m_displayname  = sName;
    }
    public String getGender(){
        return  m_gender;
    }
    void setGender(String sGender){
        m_gender  = sGender;
    }

    public String getDescription(){
        return  m_description;
    }
    void setDescription(String sDes){
        m_description  = sDes;
    }
    public String getLocation(){
        return  m_location;
    }
    void setLocation(String sLocation){
        m_location  = sLocation;
    }

    public int getAge(){
        return  m_age;
    }
    void setAge(int iAge){
        m_age  = iAge;
    }
    public int getGoodMember(){
        return  m_goodmember;
    }
    void setGoodMember(int iGoodMember){
        m_goodmember  = iGoodMember;
    }
    public int getGoodLeader(){
        return  m_goodleader;
    }
    void setGoodLeader(int iGoodLeader){
        m_goodleader  = iGoodLeader;
    }

    public int getOnLine(){
        return  m_online;
    }
    void setOnLine(int iOnline){
        m_online  = iOnline;
    }

    public String[] getInterests(){
        return  m_interests;
    }
    void setInterests(String[] aInterests){
        m_interests  = aInterests;
    }

    public String[] getJoinActivities(){
        return  m_joinactivities;
    }
    void setJoinActivities(String[] aActivities){
        m_joinactivities  = aActivities;
    }

    public String[] getHoldActivities(){
        return  m_holdactivities;
    }
    void setHoldActivities(String[] aActivities){
        m_holdactivities  = aActivities;
    }

    public String[] getSaveActivities(){
        return  m_saveactivities;
    }
    void setSaveActivities(String[] aActivities){
        m_saveactivities  = aActivities;
    }
}

package com.androidAppLogic.hangoutapp.DataStructure;

public class ActivityAttributes {

    private String m_publisheremail;	        //發佈者 (person.email) (必填)
    private String m_displayname;			    //活動名 (必填)
    private String m_location;			        //活動地點 (必填)
    private Long m_publishbegin;		        //發佈開始時間 (必填)
    private Long m_publishend;		            //發佈結束時間 (必填)
    private Long m_datebegin;		            //活動開始時間 (必填)
    private Long m_dateend;		                //活動結束時間 (必填)
    private boolean m_largeactivity;	            //是否為大型活動 (必填)(1 = 是) (預設0)
    private boolean m_earlybird;	                //是否為早鳥活動 (必填)(1 = 是)(預設0)

    private int m_id;					        //活動ID (不填) (主key)
    private int m_ts;					        //timestamp (不填)
    private int m_goodactivity;				    //好活動指數
    private int m_attention;				    //參與度
    private String m_status;			        //活動狀態 (未開始/已開始/已結束)
    private String m_image;			            //活動圖片
    private String m_description;		        //活動描述
    private String[] m_tags;			            //活動屬性 (第一個是要地區，例如 ”新北,認養,貓”)
    private String[] m_attendees;				    //參與人(person.emails)

    public  ActivityAttributes(String sEmail,
                               String sName,
                               String sLocation,
                               Long pBegin,
                               Long pEnd,
                               Long dBegin,
                               Long dEnd,
                               boolean bLarge,
                               boolean bEarly){
        m_publisheremail = sEmail;
        m_displayname = sName;
        m_location= sLocation;
        m_publishbegin = pBegin;
        m_publishend = pEnd;
        m_datebegin = dBegin;
        m_dateend = dEnd;
        m_largeactivity = bLarge;
        m_earlybird = bEarly;

    }

    public String getPublisherEmail(){
        return  m_publisheremail;
    }
    void setPublisherEmail(String sEmail){
        m_publisheremail  = sEmail;
    }

    public String getName(){
        return  m_displayname;
    }
    void setName(String sName){
        m_displayname  = sName;
    }
    public String getLocation(){
        return  m_location;
    }
    void setLocation(String sLocation){
        m_location  = sLocation;
    }
    public Long getPublisBegin(){
        return  m_publishbegin;
    }
    void setPublisBegin(Long lTime){
        m_publishbegin  = lTime;
    }
    public Long getPublisEnd(){
        return  m_publishend;
    }
    void setPublisEnd(Long lTime){
        m_publishend  = lTime;
    }
    public Long getDateBegin(){
        return  m_datebegin;
    }
    void setDateBegin(Long lTime){
        m_datebegin  = lTime;
    }
    public Long getDateEnd(){
        return  m_dateend;
    }
    void setDateEnd(Long lTime){
        m_dateend  = lTime;
    }
    public boolean getLargeActivity(){
        return  m_largeactivity;
    }
    void setLargeActivity(boolean bLarge){
        m_largeactivity  = bLarge;
    }
    public boolean getEarlyBird(){
        return  m_earlybird;
    }
    void setEarlyBird(boolean bEarly){
        m_earlybird  = bEarly;
    }

    public int getId(){
        return  m_id;
    }
    void setId(int iId){
        m_id  = iId;
    }
    public int getGoodActivity(){
        return  m_goodactivity;
    }
    void setGoodActivity(int igood){
        m_goodactivity  = igood;
    }
    public int getAttention(){
        return  m_attention;
    }
    void setAttention(int iAttens){
        m_attention  = iAttens;
    }
    public String getStatus(){
        return  m_status;
    }
    void setStatus(String sStatus){
        m_status  = sStatus;
    }
    public String getDescription(){
        return  m_description;
    }
    void setDescription(String sDes){
        m_description  = sDes;
    }

    public String[] getTags(){
        return  m_tags;
    }
    void setTags(String[] aTags){
        m_tags  = aTags;
    }
    public String[] getAttendees(){
        return  m_attendees;
    }
    void setAttendees(String[] aAttendees){
        m_attendees  = aAttendees;
    }

}

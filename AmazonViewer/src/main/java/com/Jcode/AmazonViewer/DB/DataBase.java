package com.Jcode.AmazonViewer.DB;

public class DataBase {
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String db = "amazonviewer?autoReconnect=true&useSSL=false";
	public static final String user = "root";
	public static final String password = "";
	
	/*
	 * jdbc:mysql://localhost:3306/Peoples?verifyServerCertificate=false&useSSL=true
	 * ?autoReconnect=true&useSSL=false
	 * */
	

    public static final String TMOVIE               = "movie";
    public static final String TMOVIE_ID            = "id";
    public static final String TMOVIE_TITLE         = "title";
    public static final String TMOVIE_GENRE         = "genre";
    public static final String TMOVIE_CREATOR       = "creator";
    public static final String TMOVIE_DURATION      = "duration";
    public static final String TMOVIE_YEAR          = "yeari";

    public static final String TMATERIAL            = "material";
    public static final String TMATERIAL_ID         = "id";
    public static final int [] ID_TMATERIALS        = {1,2,3,4,5};
    public static final String TMATERIAL_NAME       = "name";

    public static final String TUSER                = "user";
    public static final String TUSER_ID             = "id";
    public static final int    TUSER_IDUSUARIO      = 1;
    public static final String TUSER_NAME           = "name";

    public static final String TVIEWED              = "viewed";
    public static final String TID_ID               = "id";
    public static final String TVIEWED_IDMATERIAL   = "id_material";
    public static final String TVIEWED_IDELEMENT    = "id_element";
    public static final String TVIEWED_IDSUARIO     = "id_user";
}

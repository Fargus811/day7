package com.sergeev.day6.pool;

import com.sergeev.day6.model.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionProducer {

    private String url;
    private Properties configProp;

    private static final String DATABASE_KEY_PROPERTY = "database";
    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String AUTO_RECONNECT = "autoReconnect";
    private static final String CHARACTER_ENCODING = "encoding";
    private static final String USE_UNICODE = "useUnicode";
    private static final String DB_DATABASE_KEY_PROPERTY = "database";
    private static final String DB_URL = "url";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    private static final String DB_AUTO_RECONNECT = "autoReconnect";
    private static final String DB_CHARACTER_ENCODING = "encoding";
    private static final String DB_USE_UNICODE = "useUnicode";

    ConnectionProducer() throws DAOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_DATABASE_KEY_PROPERTY);
        configProp = new Properties();
        url = resourceBundle.getString(DB_URL);
        configProp.put(DB_USER, resourceBundle.getString(USER));
        configProp.put(DB_PASSWORD, resourceBundle.getString(PASSWORD));
        configProp.put(DB_AUTO_RECONNECT, resourceBundle.getString(AUTO_RECONNECT));
        configProp.put(DB_CHARACTER_ENCODING, resourceBundle.getString(CHARACTER_ENCODING));
        configProp.put(DB_USE_UNICODE, resourceBundle.getString(USE_UNICODE));
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            //todo make custom exception
            throw new DAOException(e);
        }
    }

    public Connection produce() throws SQLException {
        return DriverManager.getConnection(url, configProp);
    }
}


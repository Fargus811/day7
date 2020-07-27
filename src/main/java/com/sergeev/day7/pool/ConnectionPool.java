package com.sergeev.day7.pool;


import com.sergeev.day7.model.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPool {

    private static ConnectionPool instance;

    private Queue<Connection> connectionQueue;
    private Queue<Connection> givenAwayConQueue;
    private final int DEFAULT_POOL_SIZE = 10;

    private ConnectionPool() throws DaoException {
        try {
            givenAwayConQueue = new ArrayDeque<Connection>(DEFAULT_POOL_SIZE);
            connectionQueue = new ArrayDeque<Connection>(DEFAULT_POOL_SIZE);
            ConnectionProducer connectionProducer = new ConnectionProducer();
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                Connection connection = connectionProducer.produce();
                connectionQueue.add(connection);
            }
        } catch (SQLException | DaoException e) {
            throw new DaoException("SQLException in ConnectionPool", e);
        }
    }

    public static ConnectionPool getInstance() throws DaoException {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection takeConnection() {
        Connection connection = null;
        connection = connectionQueue.poll();
        givenAwayConQueue.add(connection);
        return connection;
    }


    public void close(Connection connection){
        givenAwayConQueue.remove(connection);
        connectionQueue.add(connection);
    }
}

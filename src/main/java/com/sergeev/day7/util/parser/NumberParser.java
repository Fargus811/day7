package com.sergeev.day7.util.parser;

import com.sergeev.day7.model.exception.ServiceException;

public class NumberParser {

    public int parseToInt(String number) throws ServiceException {
        int result;
        try {
            result = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    public double parseToDouble(String number) throws ServiceException {
        double result;
        try {
            result = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}

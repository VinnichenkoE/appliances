package com.vinnichenko.task1.dao;

import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.exception.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface ApplianceDAO {
    List<Appliance> find(Criteria criteria) throws DaoException;

    default void closeBufferReader(BufferedReader bufferedReader)
            throws DaoException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new DaoException(e);
            }
        }
    }
}

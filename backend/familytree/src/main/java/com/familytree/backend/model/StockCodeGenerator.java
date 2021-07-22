package com.familytree.backend.model;

import java.io.Serializable;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.commons.lang3.RandomStringUtils;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StockCodeGenerator implements IdentifierGenerator {

    //private static Logger log = Logger.getLogger(StockCodeGenerator.class);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		//String prefix = "M";
        //Connection connection = session.connection();
		/*
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('seq_stock_code') as nextval");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + StringUtils.leftPad("" + id,3, '0');
                log.debug("Generated Stock Code: " + code);
                return code;
            }

        } catch (SQLException e) {
            log.error(e);
            throw new HibernateException(
                    "Unable to generate Stock Code Sequence");
        }*/
		String id = RandomStringUtils.randomAlphanumeric(5);
        return id;
	}
}

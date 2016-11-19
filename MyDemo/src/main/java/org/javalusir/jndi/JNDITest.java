package org.javalusir.jndi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * JNDI example lookup like java:/comp/env/sourcename
 * @author lu
 *
 */
public class JNDITest {

	public static void main(String[] args) throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource source = (DataSource)ctx.lookup("java:/comp/env/jdbc/sourename");
		Connection conn = source.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("select 1 from dual");
	}
	
}

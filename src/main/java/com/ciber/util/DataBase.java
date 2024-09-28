package com.ciber.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataBase {

	public Connection getConexion() {
		Connection conexion = null;
		try {
			Context ctx = new InitialContext();

			DataSource dataSource = null;

			dataSource = (DataSource) ctx.lookup("jboss/datasources/ConsultaDS");

//			dataSource = (DataSource) ctx.lookup("java:jboss/datasources/ConsultaDS");

			conexion = dataSource.getConnection();
		} catch (Exception e) {
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
		}
		return conexion;
	}
	

	public void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
			}
		}
	}

	public void cerrarConexion(PreparedStatement sentencia) {
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
			}
		}
	}

	public void cerrarConexion(Statement sentencia) {
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
			}
		}
	}

	public void cerrarConexion(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				StringWriter stack = new StringWriter();
				e.printStackTrace(new PrintWriter(stack));
			}
		}
	}

}
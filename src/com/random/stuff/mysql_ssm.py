import os
from decimal import InvalidContext
from ConnFunction import *
import xlrd

import mysql.connector
from mysql.connector import Error

def mysql_connection(connection_details, queries):

    try:

        conn = mysql.connector.connect(user=connection_details.get('user'),passwd= connection_details.get('passwd'),host=connection_details.get('host'),auth_plugin=connection_details.get('auth_plugin'),db=connection_details.get('db'))
        if conn.is_connected():
            db_info = conn.get_server_info()
            #print(db_info)
            sql_select_Query = "select * from Employee"
            cursor = conn.cursor()
            cursor.execute(sql_select_Query)
            records = cursor.fetchall()
            print("Total number of rows in Laptop is: ", cursor.rowcount)
            return db_info

    except Error as e:
        print("Error reading data from MySQL table", e)
    finally:
        if (conn.is_connected()):
            conn.close()
            cursor.close()
            print("MySQL connection is closed")


filename="MySqlCred.xlsx"

if os.path.isfile(filename):
    wb = xlrd.open_workbook(filename)
    InputRow =[]
    Metadata_list = []
    #print(wb)
    for s in wb.sheets():
        for row in range(s.nrows):
            Col_value = []
            for col in range(s.ncols):
                value = (s.cell(row,col).value)
                #print(str(int(value)))
                #print(value)

                try:
                    value = str(int(value))
                    print(value)
                except:pass # print("Incorrect")

                Col_value.append(value.strip())
            #print(Col_value)
            InputRow.append(Col_value)
        Metadata_list.append(InputRow)
    #print(InputRow)
    print(Metadata_list)
        #InputRow = []
            #print(value)

    Source=Metadata_list[0][0][1].upper().strip()
    #print(Source)
    Target=Metadata_list[0][0][3].upper().strip()
    #print(Target)
#----------------------CONNECTION________________________#
connection_details ={}

connection_details['user'] = Metadata_list[0][1][1]
connection_details['passwd'] = Metadata_list[0][2][1]
connection_details['host'] = Metadata_list[0][3][1]
connection_details['auth_plugin'] =Metadata_list[0][4][1]
connection_details['db'] = Metadata_list[0][5][1]
#print(user,passwd,host,auth_plugin,db)
#define queries list and 
queries = []
#add queries to list strings.

if Source == 'MYSQL':
    try:
        Source_Conn = mysql_connection(connection_details, queries)
        print(Source_Conn)
    except:
        print("*"*100)
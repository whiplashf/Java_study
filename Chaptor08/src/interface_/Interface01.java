package interface_;

public class Interface01 {
        public static void main(String[] args) {
            MysqlDB mysqlDB = new MysqlDB();
            t(mysqlDB);
            OracleDB oracleDB = new OracleDB();
            t(oracleDB);

            DB_ db1 = new MysqlDB();
            ((MysqlDB)db1).work();
        }

        public static void t(DB_ db) {
            db.connect();
            db.close();
        }
}

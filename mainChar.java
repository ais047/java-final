
public class mainChar{
        private static String Name;
        private static int Atk = 10;
        private static int Def = 10;
        private static int mAtk = 10;
        private static int mDef = 10;
        private static int Spd = 5;
        private static int Hp = 60;
        private static String EquippedItm;


        public void setName (String i){
            Name = i;
        }

        public String getName() {
            return Name;
        }

        public void setAtk(int i) {
            Atk = i;
        }

        public int getAtk() {
            return Atk;
        }

        public void setDef(int i) {
            Def = i;
        }

        public int getDef() {
            return Def;
        }

        public void setmAtk(int i) {
            mAtk = i;
        }

        public int getmAtk() {
            return mAtk;
        }

        public void setmDef(int i) {
            mDef = i;
        }

        public int getmDef() {
            return mDef;
        }

        public void setSpd(int i) {
            Spd = i;
        }

        public int getSpd() {
            return Spd;
        }

        public void setHp(int i) {
            Hp = i;
        }

        public int getHp() {
            return Hp;
        }

        public void setEquippedItm(String i) {
            EquippedItm = i;
        }

        public static String getEquippedItm() {
            return EquippedItm;
        }


    }


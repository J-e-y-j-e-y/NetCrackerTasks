package week3.first;

public class InstructionSQL {
    private String tableFrom = "T_Student";
    private String tableInto = "T_GroupSelected";

    public static void main(String[] args) {
        InstructionSQL instr = new InstructionSQL();
        String query = instr.getStudents("219", 4);
        System.out.println(query);
    }

    String getStudents(String group, int dolgCount){
        String query = "INSERT INTO " + tableInto + "(id_Student, firstName, lastName, id_Group)\n";
        query += "SELECT id_Student, firstName, lastName, id_Group FROM " + tableFrom + "\n";
        query += "WHERE id_Group = '" + group + "' AND dolgCount > " + dolgCount + ";";
        return query;
    }
}

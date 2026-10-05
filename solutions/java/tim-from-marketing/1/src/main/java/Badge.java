class Badge {
    public String print(Integer id, String name, String department) {

        String depp = department == null ? "OWNER" : department.toUpperCase(); 
        
       String nameDep = name + " - " + depp;

        if(id == null) return nameDep; 
        
        return "[" + id + "] " + "- " + nameDep;  
    }
}

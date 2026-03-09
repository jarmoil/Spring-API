package fi.metropolia.jarmoil.Spring_API.dto;

public class ContactsDto {
    private int id;
    private String email;
    private String reference;
    private boolean voimassa;

    public ContactsDto(int id, String email, String reference, boolean voimassa) {
        this.id = id;
        this.email = email;
        this.reference = reference;
        this.voimassa = voimassa;
    }

    public ContactsDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getVoimassa() {
        return voimassa ? "k" : "e";
    }


    public void setVoimassa(boolean voimassa) {
        this.voimassa = voimassa;
    }

}

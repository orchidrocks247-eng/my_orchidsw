package college;

import java.util.List;

public class College {
    private final String name, location, address, phone, email, website, status, about;
    private final List<Department> departments;

    public College(String name, String location, String address, String phone,
                   String email, String website, String status, String about,
                   List<Department> departments) {
        this.name = name; this.location = location; this.address = address;
        this.phone = phone; this.email = email; this.website = website;
        this.status = status; this.about = about; this.departments = departments;
    }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getWebsite() { return website; }
    public String getStatus() { return status; }
    public String getAbout() { return about; }
    public List<Department> getDepartments() { return departments; }
}

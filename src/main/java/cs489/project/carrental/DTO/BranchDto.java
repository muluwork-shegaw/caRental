package cs489.project.carrental.DTO;


import lombok.Data;

@Data
public class BranchDto {
    private String branchName;
    private String branchLicence;
    private AddressDto address;
}

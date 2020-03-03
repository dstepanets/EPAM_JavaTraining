package go.univer.entity.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


//@Data
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@Entity(name = "admin")
//@Table(name = "users")
//@DiscriminatorValue("ADMIN")
public class AdminEntity extends UserEntity {


}



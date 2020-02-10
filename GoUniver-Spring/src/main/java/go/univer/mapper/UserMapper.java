package go.univer.mapper;

import go.univer.domain.User;
import go.univer.entity.users.UserEntity;

import java.util.Optional;

public class UserMapper implements Mapper<UserEntity, User> {
	@Override
	public UserEntity mapDomainToEntity(User item) {
		return item == null ? null :
				UserEntity.builder()
						.withId(item.getId())
						.withEmail(item.getEmail())
						.withPassword(item.getPassword())
						.withRole(getUserRoleNullSafe(item))
						.withFirstName(item.getFirstName())
						.withLastName(item.getLastName())
						.build();
	}

	private UserEntity.Role getUserRoleNullSafe(User item) {
		Optional<User.Role> userRole = Optional.ofNullable(item.getRole());
		return userRole.map(role -> UserEntity.Role.valueOf(role.name())).orElse(null);
	}

	@Override
	public User mapEntityToDomain(UserEntity enity) {
		return enity == null ? null :
				User.builder()
						.withId(enity.getId())
						.withEmail(enity.getEmail())
						.withPassword(enity.getPassword())
						.withRole(getUserEntityRoleNullSafe(enity))
						.withFirstName(enity.getFirstName())
						.withLastName(enity.getLastName())
						.build();
	}

	private User.Role getUserEntityRoleNullSafe(UserEntity enity) {
		Optional<UserEntity.Role> userEntityRole = Optional.ofNullable(enity.getRole());
		return userEntityRole.map(role -> User.Role.valueOf(role.name())).orElse(null);
	}
}

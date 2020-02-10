package go.univer.entity.users;

public class AdminEntity extends UserEntity {

	protected AdminEntity(AdminBuilder builder) {
		super(builder);
	}

	/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	public static class AdminBuilder extends UserBuilder<AdminBuilder> {

		public AdminBuilder() {
		}

		@Override
		public AdminEntity build() {
			return new AdminEntity(this);
		}

		@Override
		protected AdminBuilder self() {
			return this;
		}
	}
}



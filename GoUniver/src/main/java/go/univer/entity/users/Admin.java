package go.univer.entity.users;

public class Admin extends User {

	protected Admin(AdminBuilder builder) {
		super(builder);
	}

	/*	-	-	-	-	-	-	-	BUILDER -	-	-	-	-	-	-	-	-	*/

	public static class AdminBuilder extends UserBuilder<AdminBuilder> {

		public AdminBuilder() { }

		@Override
		public Admin build() {
			return new Admin(this);
		}

		@Override
		protected AdminBuilder self() {
			return this;
		}
	}
}



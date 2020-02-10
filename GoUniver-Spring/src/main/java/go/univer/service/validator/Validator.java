package go.univer.service.validator;

public interface Validator<E> {
	void validate(E entity);
}

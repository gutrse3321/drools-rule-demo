package ru.reimu.alice.exception.translation;

import ru.reimu.alice.constant.ErrorCode;
import ru.reimu.alice.exception.TranslationContext;
import ru.reimu.alice.exception.annotation.ExpTranslation;
import ru.reimu.alice.springExtension.view.UnifyFailureView;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.view.AbstractView;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @date 2020-09-23 15:34
 */
@ExpTranslation
public class EmptyResultExceptionTranslation extends AbstractExceptionTranslation {

    @Override
    public boolean support(Exception e) {
        return e instanceof EmptyResultDataAccessException;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        AbstractView view = new UnifyFailureView();
        view.addStaticAttribute(CODE, ErrorCode.ResourceNotFound.getCode());
        view.addStaticAttribute(THROWTYPE, getThrowType(context.getException()));
        view.addStaticAttribute(MESSAGE, interpolate(ErrorCode.ResourceNotFound.getTemplate(),null));
        return view;

    }
}

package com.example.actor.web;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/simple")
public class SimpleController {
  final static Logger logger = LoggerFactory.getLogger(SimpleController.class);

  /**
   * selectの表示に使用するアイテム
   */
  final static Map<String, String> SELECT_ITEMS =
    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
    {
      put("select_A", "A");
      put("select_B", "B");
      put("select_C", "C");
      put("select_D", "D");
      put("select_E", "E");
    }
  });

  /**
   * check boxの表示に使用するアイテム
   */
  final static Map<String, String> CHECK_ITEMS =
    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
    {
      put("checkbox_A", "A");
      put("checkbox_B", "B");
      put("checkbox_C", "C");
      put("checkbox_D", "D");
      put("checkbox_E", "E");
    }
  });

  /**
   * radio buttonの表示に使用するアイテム
   */
  final static Map<String, String> RADIO_ITEMS =
    Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
    {
      put("radio_A", "A");
      put("radio_B", "B");
      put("radio_C", "C");
      put("radio_D", "D");
      put("radio_E", "E");
    }
  });

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    //sdf.setLenient(false);
    //binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(SimpleForm form, Model model) {
    model.addAttribute("selectItems", SELECT_ITEMS);
    model.addAttribute("checkItems", CHECK_ITEMS);
    model.addAttribute("radioItems", RADIO_ITEMS);
    return "Simple/index";
  }

  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  public String confirm(@Validated @ModelAttribute SimpleForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("validationError", "不正な値が入力されました。");
      return index(form, model);
    }
    //if (StringUtils.isNotEmpty(form.getFarea())) {
    //  form.setFarea(form.getFarea().replaceAll("\n", "<br/>"));
    //}
    return "Simple/confirm";
  }

}

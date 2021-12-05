package com.spring.boot.user.service.service;

import com.spring.boot.user.service.dto.AuditDTO;
import com.spring.boot.user.service.entity.Audit;
import com.spring.boot.user.service.entity.Item;
import com.spring.boot.user.service.repository.AuditRepository;
import com.spring.boot.user.service.repository.ItemRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final ItemRepository itemRepository;
    private final AuditRepository auditRepository;

    public UserService(ItemRepository itemRepository, AuditRepository auditRepository) {
        this.itemRepository = itemRepository;
        this.auditRepository = auditRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> selectItemsWithBill(List<Integer> ids) {
        return ids.stream().map(itemRepository::getOne).collect(Collectors.toList());
    }

    public String addLogToAudit(AuditDTO auditDTO) {
        auditRepository.save(
                new Audit(auditDTO.getUser(), auditDTO.getItems(), auditDTO.getUser(), auditDTO.getTotalPrice(), auditDTO.getTime())
        );
        return "Success!";
    }

    public String getLastBill() {
        List<Audit> audits = auditRepository.findAll();
        Collections.reverse(audits);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();

        Audit usersLastAudit = audits.stream().filter(audit -> audit.getUser().equals(userName))
                .findFirst()
                .orElse(new Audit(null, "No items", null, 0, null));
        return usersLastAudit.getItems() + " selected & Final bill is ₹" + usersLastAudit.getTotalPrice();
    }

    public String getLastOneDayBill() {
        Calendar today = getStartOfToday();

        List<Audit> audits = auditRepository.findAll();
        Date startOfToday = today.getTime();
        return audits.stream()
                .filter(audit -> audit.getTime().after(startOfToday))
                .map(audit -> audit.getItems() + " Total: " + audit.getTotalPrice())
                .collect(Collectors.toList()).toString();
    }

    public String getLastOneMonthBill() {
        Calendar lastMonthToday = getStartOfToday();
        lastMonthToday.add(Calendar.DATE, -30);

        List<Audit> audits = auditRepository.findAll();
        Date lastMonthTodayTime = lastMonthToday.getTime();
        return audits.stream()
                .filter(audit -> audit.getTime().after(lastMonthTodayTime))
                .map(audit -> audit.getItems() + " Total: " + audit.getTotalPrice())
                .collect(Collectors.toList()).toString();
    }

    public static Calendar getStartOfToday() {
        Calendar today = new GregorianCalendar();
        today.setTime(new Date());
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today;
    }
}

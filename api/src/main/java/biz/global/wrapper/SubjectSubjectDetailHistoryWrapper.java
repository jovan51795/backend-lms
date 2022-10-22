package biz.global.wrapper;

import biz.global.model.Subject;
import biz.global.model.SubjectDetailHistory;

public class SubjectSubjectDetailHistoryWrapper {
        private Subject subject;
        private SubjectDetailHistory subjectDetailHistory;
        
        
        public Subject getSubject() {
            return subject;
        }
        public void setSubject(Subject subject) {
            this.subject = subject;
        }
        public SubjectDetailHistory getSubjectDetailHistory() {
            return subjectDetailHistory;
        }
        public void setSubjectDetailHistory(SubjectDetailHistory subjectDetailHistory) {
            this.subjectDetailHistory = subjectDetailHistory;
        }
        
        
}

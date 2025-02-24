if(head==null)
        {
            return false;
        }
        Node temp=head;
        
        while(temp!=null)
        {
            if(temp==head)
            {
                return true;
            }
        }
       return false;
}
